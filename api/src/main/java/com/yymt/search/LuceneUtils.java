package com.yymt.search;

import com.baomidou.mybatisplus.plugins.Page;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.api.IndexCategory;
import org.apache.commons.collections.map.HashedMap;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.lionsoul.jcseg.analyzer.JcsegAnalyzer;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * 描述:lucene工具类
 * 作者:Administrator
 * 时间:2018-03-28 16:53
 **/
@Component
public class LuceneUtils {

    static Path indexPath = null;
    static Path tempPath = null;
    static Directory directory;
    static Analyzer analyzer;
    IndexWriterConfig iwc;
    static IndexWriter writer = null;

    private static String categoryStr = Constant.LuceneField.CATEGORY.getValue();
    private static String idStr = Constant.LuceneField.ID.getValue();
    private static String typeStr = Constant.LuceneField.TYPE.getValue();
    private static String titleStr = Constant.LuceneField.TITLE.getValue();
    private static String contentStr = Constant.LuceneField.CONTENT.getValue();

    @Value("${lucene.index-dir}")
    public void setIndexDir(String pathIn) {

        try {
            analyzer = new JcsegAnalyzer(JcsegTaskConfig.COMPLEX_MODE);
            indexPath = Paths.get(pathIn);
            File file = new File(pathIn);
            if (!file.exists()) {
                file.mkdirs();
            }
            directory = FSDirectory.open(indexPath);
            iwc = new IndexWriterConfig(analyzer);
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            writer = new IndexWriter(directory, iwc);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    @Value("${lucene.index-temp}")
    public void setTempIndexDir(String path) {
        tempPath = Paths.get(path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * //建立索引
     *
     * @param data category--->搜索类别
     *             id--->数据库ID
     *             type--->所属类型
     *             title--->标题（新闻标题，心情，求助--》内容）
     *             content--->内容
     */
    @Deprecated
    public static void index(Map<String, Object> data) {
        //创建Dicturnary
        try {
            IndexCategory indexCategory;
            Object categoryObj = data.get(categoryStr);
            try {
                indexCategory = (IndexCategory) categoryObj;
            } catch (Exception e) {
                indexCategory = Enum.valueOf(IndexCategory.class, categoryObj.toString());
            }
            Integer id = Integer.parseInt(data.get(idStr).toString());
            String titleData = data.get(titleStr).toString();
            String contentData = data.get(contentStr).toString();

            indexItem(indexCategory, id, titleData, contentData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 添加索引
     *
     * @param indexCategory 搜索栏目大类
     * @param id            标识
     * @param title         标题
     * @param content       内容
     * @throws IOException
     */
    public static void indexItem(IndexCategory indexCategory, Integer id, String title, String content) throws IOException {
        Document document = new Document();
        String categoryData = indexCategory.toString();
        String idData = id.toString();
        String typeData = indexCategory.getTableName().getName();
        document.add(new StringField(categoryStr, categoryData, Field.Store.YES));
        document.add(new StringField(idStr, idData, Field.Store.YES));
        document.add(new StringField(typeStr, typeData, Field.Store.YES));
        document.add(new TextField(titleStr,
                Optional.ofNullable(title).orElse(""), Field.Store.YES));
        document.add(new TextField(contentStr,
                Optional.ofNullable(content).orElse(""), Field.Store.NO));
        long count = writer.addDocument(document);
        System.out.println("添加" + categoryData + "索引:" + count + "行受影响");
        writer.commit();
    }

    //删除
    @Deprecated
    public static void deleteWithoutMerge(Map<String, Object> data) {
        try {
            //  1．MUST和MUST：取得连个查询子句的交集。
            //  2．MUST和MUST_NOT：表示查询结果中不能包含MUST_NOT所对应得查询子句的检索结果。
            // 3．SHOULD与MUST_NOT：连用时，功能同MUST和MUST_NOT。
            // 4．SHOULD与MUST连用时，结果为MUST子句的检索结果,但是SHOULD可影响排序。
            // 5．SHOULD与SHOULD：表示“或”关系，最终检索结果为所有检索子句的并集。
            // 6．MUST_NOT和MUST_NOT：无意义，检索无结果。
            IndexCategory indexCategory;
            Object cgObj = data.get(categoryStr);
            try {
                indexCategory = (IndexCategory) cgObj;
            } catch (Exception e) {
                indexCategory = Enum.valueOf(IndexCategory.class, cgObj.toString());
            }
            Integer id = (Integer) data.get(idStr);
            deleteIndexItem(indexCategory, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除索引
     *
     * @param indexCategory 搜索栏目大类
     * @param id            标识
     * @throws IOException
     */
    public static void deleteIndexItem(IndexCategory indexCategory, Integer id) throws IOException {
        String categoryData = indexCategory.toString();
        String idData = id.toString();
        String typeData = indexCategory.getTableName().getName();
        Query categoryQuery = new TermQuery(new Term(categoryStr, categoryData));
        Query idQuery = new TermQuery(new Term(idStr, idData));
        Query typeQuery = new TermQuery(new Term(typeStr, typeData));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        builder.add(categoryQuery, BooleanClause.Occur.MUST);
        builder.add(idQuery, BooleanClause.Occur.MUST);
        builder.add(typeQuery, BooleanClause.Occur.MUST);
        BooleanQuery booleanQuery = builder.build();
        //writer.deleteDocuments(new Term("id", data.get("id").toString()),new Term("type",data.get("type").toString()));// 强制删除此时删除的文档并不会被完全删除，而是存储在一个回收站中的，可以恢复
        long count = writer.deleteDocuments(booleanQuery);
        System.out.println("删除" + categoryData + "索引:" + count + "行受影响");
        writer.commit(); //更改索引要提交，和提交数据库事务一个概念，真正的删除
    }

    /**
     * 删除指定category搜索索引
     *
     * @param indexCategory 索引大类
     * @throws IOException
     */
    public static void deleteIndexCategory(IndexCategory indexCategory) throws IOException {
        String categoryData = indexCategory.toString();
        Query categoryQuery = new TermQuery(new Term(categoryStr, categoryData));
        long count = writer.deleteDocuments(categoryQuery);
        System.out.println("删除" + categoryData + "索引:" + count + "行受影响");
        writer.commit(); //更改索引要提交，和提交数据库事务一个概念，真正的删除
    }

    //更新索引
    @Deprecated
    public static void update(Map<String, Object> data) {
        //更新暂时没有发现有多条件更新，只能死办法,先删再舔了
        try {
            deleteWithoutMerge(data);
            index(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新索引
     *
     * @param indexCategory 搜索栏目大类
     * @param id            标识
     * @param title         标题
     * @param content       内容
     * @throws IOException
     */
    public static void updateIndexItem(IndexCategory indexCategory, Integer id, String title, String content) throws IOException {
        //更新暂时没有发现有多条件更新，只能死办法,先删再舔了
        deleteIndexItem(indexCategory, id);
        indexItem(indexCategory, id, title, content);
    }

    //搜索
    public static PageUtils searcher(IndexCategory category, String searchString, int pageNum, int pageSize) throws IOException, ParseException {
        PageUtils pageUtils = new PageUtils(new Page<>(pageNum, pageSize));
        List<Map<String, Object>> data = new ArrayList<>();

        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);

        String categoryDate = category.toString();
        TermQuery categoryQuery
                = new TermQuery(new Term(categoryStr, categoryDate));

        TermQuery titleTermQuery
                = new TermQuery(new Term(titleStr, searchString));

        QueryParser titleParser = new QueryParser(titleStr, analyzer);
        Query titleParserQuery = titleParser.parse(searchString);

        TermQuery contentTermQuery
                = new TermQuery(new Term(contentStr, searchString));
        QueryParser contentParser = new QueryParser(contentStr, analyzer);
        Query contentParserQuery = contentParser.parse(searchString);

        BooleanQuery.Builder mustBuilder = new BooleanQuery.Builder();
        mustBuilder.add(categoryQuery, BooleanClause.Occur.MUST);
        BooleanQuery.Builder shouldBuilder = new BooleanQuery.Builder();
        shouldBuilder.add(titleTermQuery, BooleanClause.Occur.SHOULD);
        shouldBuilder.add(titleParserQuery, BooleanClause.Occur.SHOULD);
        shouldBuilder.add(contentTermQuery, BooleanClause.Occur.SHOULD);
        shouldBuilder.add(contentParserQuery, BooleanClause.Occur.SHOULD);
        BooleanQuery shouldBooleanQuery = shouldBuilder.build();
        mustBuilder.add(shouldBooleanQuery, BooleanClause.Occur.MUST);
        BooleanQuery booleanQuery = mustBuilder.build();

        if (pageNum < 1)
            pageNum = 1;

        int preSearchCount = 5 * pageSize;

        TopDocs results = indexSearcher.search(booleanQuery, preSearchCount);
        ScoreDoc[] hits = results.scoreDocs;

        int numTotalHits = Math.toIntExact(results.totalHits);
        int numToSearch = pageNum * pageSize;
        numToSearch = Math.min(numToSearch, numTotalHits);
        if (numToSearch > preSearchCount) {
            results = indexSearcher.search(booleanQuery, numToSearch);
            hits = results.scoreDocs;
        }
        int start = (pageNum - 1) * pageSize;
        List<Document> docs = new ArrayList<>();
        for (int i = start; i < numToSearch; i++) {
            int docId = hits[i].doc;
            Document doc = indexSearcher.doc(docId);
            docs.add(doc);
        }

        //此处加入的是搜索结果的高亮部分
          /*  SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color=red>","</font></b>"); //如果不指定参数的话，默认是加粗，即<b><b/>
            QueryScorer scorer = new QueryScorer(query);//计算得分，会初始化一个查询结果最高的得分
            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer); //根据这个得分计算出一个片段
            Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
            highlighter.setTextFragmenter(fragmenter); //设置一下要显示的片段*/

        for (Document doc : docs) {
            Map<String, Object> record = new HashedMap();
            record.put(idStr, doc.get(idStr));
            record.put(typeStr, doc.get(typeStr));
            record.put(titleStr, doc.get(titleStr));
            //显示高亮部分
               /* if(title != null) {
                    TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
                    String summary = highlighter.getBestFragment(tokenStream, title);
                    record.put("title",summary);
                }*/
            data.add(record);
        }
        pageUtils.setList(data);
        pageUtils.setTotalCount(numTotalHits);
        pageUtils.setTotalPage(numTotalHits % pageSize == 0 ?
                (numTotalHits / pageSize) : (numTotalHits / pageSize + 1));

        reader.close();

        return pageUtils;
    }

    /**
     * 合并索引文件
     */
    public static void mergeIndexFiles() {
        IndexWriter writer = null;
        Directory tempDir = null;
        try {
            tempDir = FSDirectory.open(tempPath);
            writer = new IndexWriter(directory,
                    new IndexWriterConfig(analyzer));
            writer.addIndexes(tempDir);
            writer.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (directory != null) {
                    directory.close();
                }
                if (tempDir != null) {
                    tempDir.close();
                }
                System.out.println("索引文件合并成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
