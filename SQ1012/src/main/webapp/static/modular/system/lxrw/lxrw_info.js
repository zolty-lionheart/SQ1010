/**
 * 初始化例行任务详情对话框
 */
var LxrwInfoDlg = {
    lxrwInfoData : {}
};

/**
 * 清除数据
 */
LxrwInfoDlg.clearData = function() {
    this.lxrwInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LxrwInfoDlg.set = function(key, val) {
    this.lxrwInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LxrwInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
LxrwInfoDlg.close = function() {
    parent.layer.close(window.parent.Lxrw.layerIndex);
}

/**
 * 收集数据
 */
LxrwInfoDlg.collectData = function() {
    this
    .set('id')
    .set('cjsj')
    .set('rwmc')
    .set('zt')
    .set('cjzs')
    .set('tgf')
    .set('tgs')
    .set('wtgs')
    .set('tgl')
    .set('jg')
    .set('yxsj')
    .set('dbl')
    .set('wbl')
    .set('txyc')
    .set('jsnl')
    .set('ddl5')
    .set('ddl6')
    .set('ddl7')
    .set('ddl8')
    .set('ddl9');
}

/**
 * 提交添加
 */
LxrwInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/lxrw/add", function(data){
        Feng.success("添加成功!");
        window.parent.Lxrw.table.refresh();
        LxrwInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.lxrwInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
LxrwInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/lxrw/update", function(data){
        Feng.success("修改成功!");
        window.parent.Lxrw.table.refresh();
        LxrwInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.lxrwInfoData);
    ajax.start();
}

$(function() {

});
