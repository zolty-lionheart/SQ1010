/**
 * 例行任务管理初始化
 */
var Lxrw = {
    id: "LxrwTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Lxrw.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '创建时间', field: 'cjsj', visible: true, align: 'center', valign: 'middle'},
            {title: '任务名称', field: 'rwmc', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'zt', visible: true, align: 'center', valign: 'middle'},
            {title: '场景总数', field: 'cjzs', visible: true, align: 'center', valign: 'middle'},
            // {title: '通过否', field: 'tgf', visible: true, align: 'center', valign: 'middle'},
            // {title: '通过数', field: 'tgs', visible: true, align: 'center', valign: 'middle'},
            // {title: '未通过数', field: 'wtgs', visible: true, align: 'center', valign: 'middle'},
            {title: '通过率', field: 'tgl', visible: true, align: 'center', valign: 'middle'},
            {title: '总结', field: 'jg', visible: true, align: 'center', valign: 'middle'},
            {title: '运行时间', field: 'yxsj', visible: true, align: 'center', valign: 'middle'},
           // {title: '丢包率', field: 'dbl', visible: true, align: 'center', valign: 'middle'},
           // {title: '误报率', field: 'wbl', visible: true, align: 'center', valign: 'middle'},
           // {title: '通信延迟', field: 'txyc', visible: true, align: 'center', valign: 'middle'},
           // {title: '计算能力', field: 'jsnl', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Lxrw.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Lxrw.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加例行任务
 */
Lxrw.openAddLxrw = function () {
    var index = layer.open({
        type: 2,
        title: '添加例行任务',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/lxrw/lxrw_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看例行任务详情
 */
Lxrw.openLxrwDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '例行任务详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/lxrw/lxrw_update/' + Lxrw.seItem.id
        });
        this.layerIndex = index;
    }
};
/**
 * 打开查看例行任务详情
 */
Lxrw.openLxrwDetail2 = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '例行任务详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/lxrw/lxrw_update2/' + Lxrw.seItem.id
        });
        this.layerIndex = index;
    }
};
/**
 * 生成测试报告
 */
Lxrw.testReport = function () {
    if (this.check()) {
        var formData = new FormData();
        $.ajax({
            url: Feng.ctxPath + "/lxrw/testReport/" + Lxrw.seItem.id,
            type: 'post',
            async: false,
            data: formData,
            processData: false,// 告诉jQuery不要去处理发送的数据
            contentType: false,// 告诉jQuery不要去设置Content-Type请求头
            success: function (res) {
                Feng.success("生成成功!");
            },
            error: function () {
                Feng.error("生成失败!" + data.responseJSON.message + "!");
            }
        })
    }
    Lxrw.table.refresh();
};


/**
 * 删除例行任务
 */
Lxrw.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/lxrw/delete", function (data) {
            Feng.success("删除成功!");
            Lxrw.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("lxrwId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询例行任务列表
 */
Lxrw.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Lxrw.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Lxrw.initColumn();
    var table = new BSTable(Lxrw.id, "/lxrw/list", defaultColunms);
    table.setPaginationType("client");
    Lxrw.table = table.init();
});
