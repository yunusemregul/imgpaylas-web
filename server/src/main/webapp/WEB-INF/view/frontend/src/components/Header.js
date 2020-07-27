import React from "react";
import { withRouter } from "react-router-dom";
import "../assets/style/style.css";
import logo from "../assets/images/logo.png";
import icon_back from "../assets/images/icon_back.png";

function Header(props) {
  return (
    <div
      className="header row-fixed"
      style={{
        position: "relative",
        height: "102px",
      }}
    >
      {props.title ? (
        <>
          <img
            src={icon_back}
            className="clickable"
            style={{ position: "absolute", top: 25, left: 20 }}
            onClick={() => {
              props.history.goBack();
            }}
          />
          <div
            style={{
              color: "white",
              fontSize: "40px",
              margin: "auto",
              width: "50%",
              textAlign: "center",
              marginTop: "23px",
            }}
          >
            {props.title}
          </div>
        </>
      ) : (
        <>
          {" "}
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
              padding: 25,
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
            <button
              className="header-button header-button-register"
              onClick={() => {
                props.history.push("/register");
              }}
            >
              Kayıt Ol
            </button>
          </div>
        </>
      )}
    </div>
  );
}

export default withRouter(Header);
