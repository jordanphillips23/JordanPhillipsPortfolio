var map;
function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
    zoom: 0,
    center: {lat: 0, lng: 0}
  });

	$.get('/getmapdata', setMapMarkers)
}
	
	




function setMapMarkers(response, textStatus, jqXHR) {
	console.log(response);
}