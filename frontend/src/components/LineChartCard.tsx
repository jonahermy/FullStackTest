import React, { useEffect, useState } from "react";
import {
  Card,
  CardContent,
  Typography,
  CircularProgress,
  Box,
} from "@mui/material";

import {
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";

import { Line } from "react-chartjs-2";

ChartJS.register(
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Title,
  Tooltip,
  Legend
);

const LineChartCard: React.FC = () => {
  const [dataPoints, setDataPoints] = useState<number[] | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch(`${process.env.REACT_APP_API_URL}/dashboard`)
      .then((res) => res.json())
      .then((data: number[]) => {
        setDataPoints(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error("Failed to fetch data", err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return (
      <Box
        display="flex"
        justifyContent="center"
        alignItems="center"
        height={200}
      >
        <CircularProgress />
      </Box>
    );
  }

  if (!dataPoints) {
    return (
      <Typography color="error" align="center">
        Failed to load data.
      </Typography>
    );
  }

  const chartData = {
    labels: dataPoints.map((_, i) => `Point ${i + 1}`),
    datasets: [
      {
        label: "Numbers from backend",
        data: dataPoints,
        fill: false,
        borderColor: "#1976d2",
        tension: 0.3,
      },
    ],
  };

  const chartOptions = {
    responsive: true,
    plugins: {
      legend: {
        position: "top" as const,
      },
      title: {
        display: true,
        text: "Development of random Test data",
      },
    },
  };

  return (
    <Card>
      <CardContent>
        <Typography variant="h6" gutterBottom>
          Line Chart
        </Typography>
        <Line data={chartData} options={chartOptions} />
      </CardContent>
    </Card>
  );
};

export default LineChartCard;
