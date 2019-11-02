from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from .getLoadData import getLoadData
from portfolioMain.models import location
from django.core import serializers
from django.conf import settings


def getMapData(request):
	# ip = ""
	# x_forwarded_for = request.META.get('HTTP_X_FORWARDED_FOR')
 #    if (x_forwarded_for):
 #        ip = x_forwarded_for.split(',')[-1].strip()
    
 #    else:
 #        ip = request.META.get('REMOTE_ADDR')
    
    
 #    if (location.objects.filter(ip = ip).count() == 0):
 #    	if (location.objects.count() == 100):
 #    		location.objects.first().delete()



    # connects to ip to location api


	# prevents duplicate objects
		
			# loc = location(latitude = lat, longitude = lon)
			# loc.save()
	return JsonResponse(list(location.objects.values()), safe = False)


def javascript(request):
	return render(request, 'portfolioMain/pages/javascript.html', context = getLoadData())

