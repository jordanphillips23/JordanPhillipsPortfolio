# Generated by Django 2.2.5 on 2019-11-02 19:33

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('portfolioMain', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='location',
            name='ip',
            field=models.CharField(default='', max_length=40),
            preserve_default=False,
        ),
    ]