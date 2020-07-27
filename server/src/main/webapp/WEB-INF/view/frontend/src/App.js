import React from "react";
import { BrowserRouter, Route } from "react-router-dom";
import "./assets/style/style.css";
import Login from "./pages/Login";
import Main from "./components/Main";

function App() {
  return (
    <BrowserRouter>
      <Route exact path="/" component={Main} />
      <Route path="/index.html" component={Main} />
      <Route path="/login" component={Login} />
    </BrowserRouter>
  );
}

export default App;
