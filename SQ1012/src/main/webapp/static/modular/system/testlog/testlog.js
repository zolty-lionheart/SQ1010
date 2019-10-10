/**
 * 测试详情管理初始化
 */
var Testlog = {
    id: "TestlogTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Testlog.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '任务名称', field: 'rwmc', visible: true, align: 'center', valign: 'middle'},
            {title: '用例名', field: 'scenario', visible: true, align: 'center', valign: 'middle'},
        {
            title: '通过否',
            field: 'tgf',
            visible: true,
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                if (row.tgf == "1") {
                    return "通过";
                } else {
                    return "不通过";

                }
            }
        }
    ];
};

/**
 * 检查是否选中
 */
Testlog.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Testlog.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加测试详情
 */
Testlog.openAddTestlog = function () {
    var index = layer.open({
        type: 2,
        title: '添加测试详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/testlog/testlog_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看测试详情详情
 */
Testlog.openTestlogDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '测试详情详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/testlog/testlog_update/' + Testlog.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除测试详情
 */
Testlog.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/testlog/delete", function (data) {
            Feng.success("删除成功!");
            Testlog.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("testlogId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询测试详情列表
 */
Testlog.search = function () {
    var queryData = {};
    queryData['condition'] = $("#rwmc").val();
    Testlog.table.refresh({query: queryData});
};

$(function () {
    var condition=$("#rwmc").val();
    var defaultColunms = Testlog.initColumn();
    var table = new BSTable(Testlog.id, "/testlog/list/"+condition, defaultColunms);
    table.setPaginationType("client");
    Testlog.table = table.init();
});
