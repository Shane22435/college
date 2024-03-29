from email.policy import default
from django.db import models
from django.contrib.auth.models import AbstractUser

from django.db import models
from django.contrib.auth.models import AbstractUser, BaseUserManager


class UserManager(BaseUserManager):
    """Define a model manager for User model with no username field."""

    use_in_migrations = True

    def _create_user(self, email, password, **extra_fields):
        """Create and save a User with the given email and password."""
        if not email:
            raise ValueError('The given email must be set')
        email = self.normalize_email(email)
        user = self.model(email=email, **extra_fields)
        user.set_password(password)
        user.save(using=self._db)
        return user

    def create_user(self, email, password=None, **extra_fields):
        """Create and save a regular User with the given email and password."""
        extra_fields.setdefault('is_staff', False)
        extra_fields.setdefault('is_superuser', False)
        return self._create_user(email, password, **extra_fields)

    def create_superuser(self, email, password, **extra_fields):
        """Create and save a SuperUser with the given email and password."""
        extra_fields.setdefault('is_staff', True)
        extra_fields.setdefault('is_superuser', True)

        if extra_fields.get('is_staff') is not True:
            raise ValueError('Superuser must have is_staff=True.')
        if extra_fields.get('is_superuser') is not True:
            raise ValueError('Superuser must have is_superuser=True.')

        return self._create_user(email, password, **extra_fields)


class User(AbstractUser):
    email = models.EmailField('Email', unique=True)
    USERNAME_FIELD = 'email'
    REQUIRED_FIELDS = []
    objects = UserManager()


class Size(models.Model):
    name = models.CharField(max_length=100)
    price = models.DecimalField(max_digits=6, decimal_places=2)

    def __str__(self):
        return self.name


class Crust(models.Model):
    name = models.CharField(max_length=100)

    def __str__(self):
        return self.name


class Sauce(models.Model):
    name = models.CharField(max_length=100)

    def __str__(self):
        return self.name


class Cheese(models.Model):
    name = models.CharField(max_length=100)

    def __str__(self):
        return self.name


class Topping(models.Model):
    name = models.CharField(max_length=100)

    def __str__(self):
        return self.name


class Pizza(models.Model):
    size = models.ForeignKey(Size, on_delete=models.CASCADE, null=True)
    crust = models.ForeignKey(Crust, on_delete=models.CASCADE, null=True)
    sauce = models.ForeignKey(Sauce, on_delete=models.CASCADE, null=True)
    cheese = models.ForeignKey(Cheese, on_delete=models.CASCADE, null=True)
    toppings = models.ManyToManyField(Topping, blank=True)

    def __str__(self):
        return f"{self.size} {self.crust} Pizza"


class Order(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    pizza = models.ManyToManyField(Pizza)
    name = models.CharField(max_length=100)
    street_address = models.CharField(max_length=100, default='')
    city = models.CharField(max_length=100, default='')
    county = models.CharField(max_length=100, default='')
    zip_code = models.CharField(max_length=100, default='')
    country = models.CharField(max_length=100, default='')
    card_number = models.CharField(max_length=19)
    card_expiry_month = models.PositiveIntegerField()
    card_expiry_year = models.PositiveIntegerField()
    card_cvv = models.PositiveIntegerField()
    order_date = models.DateTimeField(auto_now_add=True)
    delivery_date = models.DateTimeField(null=True)
    delivery_time = models.TimeField(null=True)

    def __str__(self):
        return f"Order for {self.name}"