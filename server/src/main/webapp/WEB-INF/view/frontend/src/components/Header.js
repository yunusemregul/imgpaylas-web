import React from "react";
import { withRouter } from "react-router-dom";
import logo from "../assets/images/logo.png";
import "../assets/style/style.css";

function Header(props) {
  return (
    <div className="header row-fixed">
      <img src={logo} alt="logo" style={{ padding: 12, width: "64px" }} />
    </div>
  );
}

export default withRouter(Header);
