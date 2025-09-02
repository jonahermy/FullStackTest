using Backend.Controllers;

namespace Backend.Tests.Controllers;

public class WeatherForecastControllerTest
{
    private WeatherForecastController _controller;

    [SetUp]
    public void Setup()
    {
        _controller = new WeatherForecastController();
    }

    [Test]
    public void TestGetWeatherForecast()
    {
        IEnumerable<WeatherForecast> result = _controller.Get();
        var resultList = result.ToList();

        Assert.That(resultList, Is.Not.Null);
        Assert.That(resultList.Count, Is.EqualTo(5));

        var now = DateTime.Now;

        foreach (var forecastEntry in resultList)
        {
            Assert.That(forecastEntry.Date > now, Is.True, "Forecast date must be in the future");
            Assert.That(forecastEntry.TemperatureC < forecastEntry.TemperatureF, Is.True, "Fahrenheit must be greater than Celsius");
        }
    }
}