from django.shortcuts import render
from django.http import HttpResponse
from .getLoadData import getLoadData


def python(request):
	return render(request, 'portfolioMain/pages/python.html', context = getLoadData())
