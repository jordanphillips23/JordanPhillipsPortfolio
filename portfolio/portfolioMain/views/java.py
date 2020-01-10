from django.shortcuts import render
from django.http import HttpResponse
from .getLoadData import getLoadData


def java(request):
	return render(request, 'portfolioMain/pages/java.html', context = getLoadData())