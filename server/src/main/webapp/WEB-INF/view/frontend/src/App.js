import React from "react";
import { BrowserRouter, Route } from "react-router-dom";
import "./App.css";
import Login from "./Login";
import Main from "./Main";

function App() {
  return (
    <BrowserRouter>
      <Route exact path="/" component={Main} />
      <Route path="/login" component={Login} />
    </BrowserRouter>
  );
}

export default App;
