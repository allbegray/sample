/**
 * Created by allbegray on 2016-06-18.
 */
(function ($) {
    'use strict';

    $.extend($.fn.bootstrapTable.defaults, {
        locale: 'ko-KR',
        sidePagination: 'server',
        pagination: true,
        pageSize: 10,
        pageList: [10, 20, 30, 40, 50],
        showColumns: true,
        queryParams: function (params) {
            return {
                keyword: params.searchText,
                sort: params.sortName + "," + params.sortOrder,
                size: params.pageSize,
                page: params.pageNumber
            };
        },
        queryParamsType: '',
        responseHandler: function (res) {
            return {
                total: res.totalElements,
                rows: res.content
            }
        }
    });
})(jQuery);

function dateFormatter(value) {
    return moment(value).format('YYYY-MM-DD HH:mm:ss');
}

function dateTimeFormatter(value) {
    return moment(value).format('YYYY-MM-DD');
}