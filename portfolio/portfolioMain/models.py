from django.db import models

# Create your models here.
class location(models.Model):
	latitude = models.DecimalField(max_digits=9, decimal_places=6)
	longitude = models.DecimalField(max_digits=9, decimal_places=6)
	ip = models.CharField(max_length = 40)
