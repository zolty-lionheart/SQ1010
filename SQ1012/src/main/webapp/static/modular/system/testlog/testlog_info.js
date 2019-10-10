/**
 * 初始化测试详情详情对话框
 */
var TestlogInfoDlg = {
    testlogInfoData : {}
};

/**
 * 清除数据
 */
TestlogInfoDlg.clearData = function() {
    this.testlogInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TestlogInfoDlg.set = function(key, val) {
    this.testlogInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TestlogInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TestlogInfoDlg.close = function() {
    parent.layer.close(window.parent.Testlog.layerIndex);
}

/**
 * 收集数据
 */
TestlogInfoDlg.collectData = function() {
    this
    .set('id')
    .set('rwmc')
    .set('scenario')
    .set('tgf');
}

/**
 * 提交添加
 */
TestlogInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/testlog/add", function(data){
        Feng.success("添加成功!");
        window.parent.Testlog.table.refresh();
        TestlogInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.testlogInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TestlogInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/testlog/update", function(data){
        Feng.success("修改成功!");
        window.parent.Testlog.table.refresh();
        TestlogInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.testlogInfoData);
    ajax.start();
}

$(function() {

});
