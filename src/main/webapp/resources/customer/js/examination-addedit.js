$(function() {
	
	var code = getQueryString('code');
	var view = getQueryString('v');
	var router = '/customer/examination';
	
	var fields = [{
		title: '申请企业',
		field: 'company-name',
		readonly: true,
		type: 'm2o',
		url: $('#basePath').val() + '/general/company_addedit.htm',
		codeField: 'companyCode'
	}, {
		title: '资质',
		field: 'certificate-name',
		readonly: true,
		type: 'm2o',
		url: $('#basePath').val() + '/general/qualification_addedit.htm',
		codeField: 'certificateCode'
	}, {
		title: '报价区间',
		field: 'remark',
		readonly: true,
		formatter: function(v, r) {
			return r.company.remark;
		}
	}, {
		title: '审核意见',
		field: 'approveNote',
		maxlength: 255,
		required: true,
		readonly:!!view,
	}];
	
	var options = {};
	if (view) {
		options.buttons = [{
			'title': '返回',
			handler: function() {
				goBack();
			}
		}];
	}
	buildDetail(router, fields, code, options);
	
	
});