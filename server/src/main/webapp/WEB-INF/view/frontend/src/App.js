import React from "react";
import { BrowserRouter, Route } from "react-router-dom";
import "./assets/style/style.css";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Main from "./pages/Main";

function App() {
  return (
    <BrowserRouter>
      <Route exact path="/" component={Main} />
      <Route path="/index.html" component={Main} />
      <Route path="/login" component={Login} />
      <Route path="/register" component={Register} />
    </BrowserRouter>
  );
}

export default App;
