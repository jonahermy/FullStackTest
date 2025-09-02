using Backend.Controllers;

namespace Backend.Tests.Controllers;

public class DashboardControllerTest
{
    
    private DashboardController _controller;

    [SetUp]
    public void Setup()
    {
        _controller = new DashboardController();
    }

    [Test]
    public void TestDashboardController()
    {
        List<int> result = _controller.Get();

        Assert.That(result, Is.Not.Null);
        Assert.That(result.Count, Is.EqualTo(5));

        foreach (int number in result)
        {
            Assert.That(number, Is.GreaterThan(0));
        }
    }
}