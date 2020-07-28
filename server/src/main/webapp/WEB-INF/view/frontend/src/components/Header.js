import React from "react";
import { withRouter } from "react-router-dom";
import logo from "../assets/images/logo.png";
import "../assets/style/style.css";

function Header(props) {
  return (
    <div className="header row-fixed">
      <img
        src={logo}
        alt="logo"
        style={{ padding: 12, cursor: "pointer", width: "64px" }}
        onClick={() => {
          window.location.href = "/";
        }}
      />
    </div>
  );
}

export default withRouter(Header);
