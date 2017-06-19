$(function() {

    var code = getQueryString('code');

    var fields = [{
            title: 'UI位置',
            field: 'location',
            type: 'select',
            data: {
                '0': '普通',
                '1': '热门'
            },
            required: true,
            // readonly: true
        },
        {
            title: 'UI次序',
            field: 'orderNo',
            number: true,
            required: true,
        }
    ];

    var options = {
        fields: fields,
        code: code,
        detailCode: '612062',

    };

    options.buttons = [{
        title: '保存',
        handler: function() {
            if ($('#jsForm').valid()) {
                var data = {};
                data['code'] = code;
                data['updater'] = sessionStorage.getItem('userName');
                data["location"] = $("#location").val();
                data["orderNo"] = $("#orderNo").val();
                reqApi({
                    code: "612053",
                    json: data
                }).done(function() {
                    sucDetail();
                });
            }
        }
    }, {
        title: '返回',
        handler: function() {
            goBack();
        }
    }];

    buildDetail(options);

});