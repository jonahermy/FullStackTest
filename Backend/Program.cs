var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllers();
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll",
        builder => builder.AllowAnyOrigin().AllowAnyMethod().AllowAnyHeader());
});

// Optional: Enable CORS, Swagger, etc.
// builder.Services.AddCors(...);
// builder.Services.AddEndpointsApiExplorer();
// builder.Services.AddSwaggerGen();

var app = builder.Build();

// Optional middleware
// app.UseSwagger();
// app.UseSwaggerUI();

app.UseHttpsRedirection();
app.UseAuthorization();

app.UseCors("AllowAll");
app.MapControllers();

app.Urls.Add("http://0.0.0.0:5000");

app.Run();

