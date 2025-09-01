import React from "react";
import { Container, CssBaseline, Typography } from "@mui/material";
import LineChartCard from "./LineChartCard";

const Dashboard: React.FC = () => {
  return (
    <>
      <CssBaseline />
      <Container maxWidth="sm" sx={{ mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          Data Visualization
        </Typography>
        <LineChartCard />
      </Container>
    </>
  );
};

export default Dashboard;
