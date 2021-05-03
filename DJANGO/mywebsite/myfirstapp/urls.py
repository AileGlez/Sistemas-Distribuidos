from django.urls import path
from . import views

urlpatterns = [
    path('', views.index,name="index"),
    path('<int:estudiante_id>/detalles/', views.detalles,name="detalles"),
    path('<int:estudiante_id>/carreras/', views.carreras,name="carreras"),
    path('<int:estudiante_id>/agrega_carrera/', views.agrega_carrera,name="agrega_carrera"),
]