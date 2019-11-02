from os import listdir
from django.conf import settings

# returns a dictionary of all the load data
def getLoadData():
	return {"cssData": getCssData(), "pageNames" : getPageNames(), "GOOGLE_AUTH": settings.GOOGLE_AUTH}
# finds the names of all css files and returns them as a list
def getCssData():
	return listdir("portfolioMain/static/css")

def getPageNames():
	out = []
	# gets the name of all the html pages except the home page
	for name in listdir("portfolioMain/templates/portfolioMain/pages"):
		if (name != "home.html"):
			out.append(name.split(".")[0])
	return out
