from django.urls import path, include
from . import views

urlpatterns = [
    path('', views.index, name="index"),
    path('contact.html', views.contact, name ="contact"),
    path("menu.html", views.menu, name="menu"),
    path("order.html", views.order, name="order")
]