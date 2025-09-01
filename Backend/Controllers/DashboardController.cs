using Microsoft.AspNetCore.Mvc;

namespace Backend.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class DashboardController : ControllerBase
    {
        [HttpGet]
        public List<int> Get()
        {
            List<int> testList = new List<int>();
            Random rand = new Random();
            int last = rand.Next(50, 100);

            for (int i = 0; i < 5; i++)
            {
                int next;
                if (i % 2 == 0)
                {
                    next = last + (rand.Next(10, 50) * last / 100);
                }
                else
                {
                    next = last - (rand.Next(10, 50) * last / 100);
                }
                last = next;
                testList.Add(next);
            }
            return testList;
        }
    }

}

