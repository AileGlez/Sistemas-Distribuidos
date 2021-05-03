from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def index(request):
    return HttpResponse("Hola mundo a todos")

def detalles(request, estudiante_id):
    return HttpResponse("Detalles del estudiante %s" % estudiante_id)

def carreras(request, estudiante_id):
    return HttpResponse("Carreras del estudiante %s" % estudiante_id)

def agrega_carrera(request, estudiante_id):
    return HttpResponse("Carrera agregada al estudiante %s" % estudiante_id)

