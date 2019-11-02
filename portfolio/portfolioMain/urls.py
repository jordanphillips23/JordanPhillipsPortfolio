from django.urls import path, include
from portfolioMain.views import home, python, javascript
urlpatterns = [
	path('', home.home, name = "home"),
	path('home', home.redirectHome, name = "redirectHome"),
	path('python', python.python, name = "python"),
	path('javascript', javascript.javascript, name = "javascript"),
	path('getmapdata', javascript.getMapData, name = "getMapData")
]
