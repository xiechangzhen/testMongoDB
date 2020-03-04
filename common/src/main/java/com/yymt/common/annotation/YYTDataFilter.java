/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.yymt.common.annotation;

import java.lang.annotation.*;

/**
 * 数据过滤
 *
 * @author hgq
 * @since 2018-11-15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YYTDataFilter {
    /**  表的别名 */
    String tableAlias() default "";

    /**  true：能查询本人数据 */
    boolean user() default true;

    /**  数据发布者在表格中的字段名 */
    String userId() default "user_id";

    /**  审核权限 */
    String auditPermission() default "";
}
