import React from "react";
import { withRouter } from "react-router-dom";
import "../assets/style/style.css";
import logo from "../assets/images/logo.png";

function Header(props) {
  return (
    <div
      className="header row-fixed"
      style={{
        position: "relative",
        height: "102px",
      }}
    >
      <img
        src={logo}
        alt="logo"
        style={{ margin: 20, cursor: "pointer" }}
        onClick={() => {
          props.history.push("/");
        }}
      />
      <div
        style={{
          display: "flex",
          flexDirection: "row",
          position: "absolute",
          right: 0,
          top: 0,
          bottom: 0,
          padding: 20,
        }}
      >
        <button
          className="header-button header-button-login"
          style={{
            marginRight: 20,
          }}
          onClick={() => {
            props.history.push("/login");
          }}
        >
          Giriş Yap
        </button>
        <button className="header-button header-button-register">
          Kayıt Ol
        </button>
      </div>
    </div>
  );
}

export default withRouter(Header);
