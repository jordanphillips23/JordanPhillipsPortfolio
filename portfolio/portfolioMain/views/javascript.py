from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from .getLoadData import getLoadData
from portfolioMain.models import location
from django.core import serializers
from django.conf import settings
import requests



def getMapData(request):
	ip = ""
	forwarded = request.META.get('HTTP_X_FORWARDED_FOR')
	if (forwarded):
 		ip = forwarded.split(',')[-1].strip()
	else:
		ip = request.META.get('REMOTE_ADDR')
    
	if (location.objects.filter(ip = ip).count() == 0):
		if (location.objects.count() == 100):
			location.objects.first().delete()

		if(ip == '127.0.0.1'):
			ip = '72.229.28.185'

    # connects to ip to location api
		response = requests.get('http://api.ipstack.com/' + ip + '?access_key=' + settings.IPSTACK_AUTH + '&fields=latitude,longitude')
		if response:
			data = response.json()
			if ( not data['latitude'] == None):
				loc = location(latitude = data['latitude'], longitude = data['longitude'], ip = ip)
				loc.save()
	return JsonResponse(list(location.objects.values()), safe = False)


def javascript(request):
	return render(request, 'portfolioMain/pages/javascript.html', context = getLoadData())

