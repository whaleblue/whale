/**
 * 加载地图服务
 */
$(document).ready(function() {	
	loadMap();
});

function loadMap(){
	/*var userForm = new Object(); 
	userForm.userCode = $("#userCode").val(); 
	var myData = JSON.stringify(userForm); */
	var myData = "";
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : contextPath+"/springmvc/map/json",
		processData : false,
		dataType : "json",
		data : myData,
		success : function(data) {		
			initialize(data);
		},
		error : function() {
			alert("ERROR");
		}
	});
}

function initialize(data){	
	//获取地图对象
	var mapObj = getMapObj(data);			
											
	//地图中添加地图操作MarkerClusterer插件
	setMarkerClustererPlugin(mapObj, data);
	
	//地图中添加地图操作ToolBar插件
	setToolBarPlugin(mapObj);
}

function getMapObj(data) {
	var mapObj = new AMap.Map("container",{
		view: new AMap.View2D({//创建地图二维视口
		center:new AMap.LngLat(121.476345,31.228803),//创建中心点坐标
		zoom: 3, //设置地图缩放级别
		rotation:0 //设置地图旋转角度
	}), 
		lang:"zh_cn"//设置地图语言类型，默认：中文简体
	});//创建地图实例

	return mapObj;
}

function getMarkers(mapObj, data) {
	var markers= [];
	$.each(data, function(index, dataItem){
		var icon = dataItem.brandIcon;
		$.each(dataItem.entityList, function(index,content){							
			markers.push(getMarkerItem(mapObj, icon, content));
		}); 
	});  
	
	return markers;			
}
function setMarkerClustererPlugin(mapObj, data) {
	mapObj.plugin(["AMap.MarkerClusterer"],function(){
		new AMap.MarkerClusterer(mapObj, getMarkers(mapObj, data));
	});
}

function setToolBarPlugin(mapObj){
	mapObj.plugin(['AMap.ToolBar'],function(){
		//设置地位标记为自定义标记
		var toolBar = new AMap.ToolBar(); 
		mapObj.addControl(toolBar);		
	});	
}

function getMarkerItem(mapObj, icon, content){
	var markerPosition = new AMap.LngLat(content.lngX, content.latY);
	var marker = new AMap.Marker({
		//基点位置
		position: markerPosition, 
		//marker图标，直接传递地址url
		//icon:"http://developer.amap.com/wp-content/uploads/2014/06/marker.png", 
		icon:contextPath+icon,
		//content:"",
		title:content.shortName,
		//相对于基点的位置
		offset:{x:-8, y:-34} 
	});
	
	AMap.event.addListener(marker, 'click', function () {
		var infoWindow = new AMap.InfoWindow({
			content:"<h3><font face=\"微软雅黑\"color=\"#3366FF\">"+content.name+"</font></h3><hr />地址："+content.address+"<br />电话："+content.telephone,
    		autoMove:true,
    		offset:new AMap.Pixel(0,-25)
		});
		infoWindow.open(mapObj, markerPosition);
	});
	
	return marker;
}		