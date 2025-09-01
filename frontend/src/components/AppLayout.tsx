import {
  AppBar,
  Toolbar,
  Typography,
  Drawer,
  List,
  ListItem,
  ListItemText,
  ListItemButton,
  CssBaseline,
  Box,
} from "@mui/material";

import { useNavigate, Routes, Route } from "react-router-dom";
import Forecast from "./Forecast";
import Dashboard from "./Dashboard";

const drawerWidth = 240;

const NavigationList = () => {
  const navigate = useNavigate();

  const mainLinks = [
    { text: "Dashboard", path: "/" },
    { text: "Forecast", path: "/forecast" },
  ];

  return (
    <Box sx={{ overflow: "auto" }}>
      <List>
        {mainLinks.map(({ text, path }) => (
          <ListItem key={text} disablePadding>
            <ListItemButton onClick={() => navigate(path)}>
              <ListItemText primary={text} />
            </ListItemButton>
          </ListItem>
        ))}
      </List>
    </Box>
  );
};

const AppLayout = () => {
  return (
    <>
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}
      >
        <Toolbar>
          <Typography variant="h6" noWrap component="div">
            Test App
          </Typography>
        </Toolbar>
      </AppBar>

      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: {
            width: drawerWidth,
            boxSizing: "border-box",
          },
        }}
      >
        <Toolbar />
        <NavigationList />
      </Drawer>

      <Box
        component="main"
        sx={{ flexGrow: 1, p: 3, ml: `${drawerWidth}px`, mt: "64px" }}
      >
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/forecast" element={<Forecast />} />
        </Routes>
      </Box>
    </>
  );
};

export default AppLayout;
