from django.shortcuts import render
from django.http import HttpResponse
from .getLoadData import getLoadData
from django.shortcuts import redirect

def home(request):
	return render(request, 'portfolioMain/pages/home.html', context = getLoadData())

def redirectHome(request):
	return redirect("/")