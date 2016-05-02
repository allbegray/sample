/**
 * Created by allbegray on 2016-05-02.
 */
$(function () {
    $.ajaxSetup({ cache: false });
    $(document).ajaxStart(function () {
        // 블럭 UI 설정
        // $.blockUI({
        //     message: options.AjaxWait.AjaxWaitMessage,
        //     css: options.AjaxWait.AjaxWaitMessageCss
        // });
    }).ajaxSend(function (event, jqxhr, settings) {
    }).ajaxError(function (event, jqxhr, settings) {
        if (jqxhr.status == 0) {
            alert('오프라인 상태입니다. 네트워크를 확인하세요.');
        } else if (jqxhr.status == 403) {
            alert('로그인 정보가 존재하지 않습니다.');
        } else if (jqxhr.status == 403) {
            alert("접근 권한이 없습니다. 로그인 정보를 확인하세요.");
        } else if (jqxhr.status == 404) {
            alert("요청에 문제가 발생하였습니다. 다시 시도해주세요.");
        } else {
            alert("error[" + jqxhr.status + "]\nError: " + jqxhr.responseText);
        }
    }).ajaxSuccess(function (event, jqxhr, settings) {
    }).ajaxComplete(function (event, jqxhr, settings) {
    }).ajaxStop(function () {
        // 블럭 UI 해제
        // $.unblockUI();
    });
});