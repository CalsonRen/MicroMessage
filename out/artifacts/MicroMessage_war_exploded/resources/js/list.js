/**
 * Created by renjie on 17/1/21.
 * js file for list.jsp
 */

function deleteBatch(basePath){
    $("#mainForm").attr("action", basePath + "DeleteBatch.action");
    $("#mainForm").submit();
}
