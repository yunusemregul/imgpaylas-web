import React from "react";
import { BrowserRouter, Route } from "react-router-dom";
import "./assets/style/style.css";
import Home from "./pages/Home";
import Likes from "./pages/Likes";
import Login from "./pages/Login";
import Profile from "./pages/Profile";
import Register from "./pages/Register";
import Upload from "./pages/Upload";

function App() {
  return (
    <BrowserRouter>
      <Route exact path="/" component={Login} />
      <Route path="/index.html" component={Login} />
      <Route path="/login" component={Login} />
      <Route path="/register" component={Register} />

      <Route path="/home" component={Home} />
      <Route path="/likes" component={Likes} />
      <Route path="/profile" component={Profile} />
      <Route path="/upload" component={Upload} />
    </BrowserRouter>
  );
}

export default App;
