import React, { useEffect, useState } from "react";
import axios from "axios";
import { Container, Grid, Card, CardContent, Typography } from "@mui/material";

interface WeatherForecast {
  date: string;
  temperatureC: number;
  temperatureF: number;
  summary: string;
}

const Forecast = () => {
  const [forecasts, setForecasts] = useState<WeatherForecast[]>([]);

  useEffect(() => {
    axios
      .get(`${process.env.REACT_APP_API_URL}/weatherforecast`)
      .then((res) => setForecasts(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <Container maxWidth="md">
      <Grid container spacing={2}>
        {forecasts.map((forecast, index) => (
          <Grid {...{ item: true, xs: 12, sm: 6, md: 4 }} key={index}>
            <Card>
              <CardContent>
                <Typography variant="h6">
                  {new Date(forecast.date).toLocaleDateString()}
                </Typography>
                <Typography>
                  🌡 {forecast.temperatureC}°C / {forecast.temperatureF}°F
                </Typography>
                <Typography>☁️ {forecast.summary}</Typography>
              </CardContent>
            </Card>
          </Grid>
        ))}
      </Grid>
    </Container>
  );
};

export default Forecast;
