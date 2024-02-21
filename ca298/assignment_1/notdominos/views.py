import re
from django.shortcuts import render
import random

# Create your views here.

def index(request):
    return render(request, 'index.html')

def contact(request):
    return render(request, 'contact.html')

def menu(request):
    return render(request, 'menu.html')

def order(request):
    return render(request, "order.html")