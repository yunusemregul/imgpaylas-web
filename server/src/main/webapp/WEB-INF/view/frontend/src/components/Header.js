import React, { useState, useEffect } from "react";
import { withRouter } from "react-router-dom";
import logo from "../assets/images/logo.png";
import "../assets/style/style.css";
import home from "../assets/images/icon_home.png";
import home_focused from "../assets/images/icon_home_focused.png";
import likes from "../assets/images/icon_likes.png";
import likes_focused from "../assets/images/icon_likes_focused.png";
import profile from "../assets/images/icon_profile.png";
import profile_focused from "../assets/images/icon_profile_focused.png";
import upload from "../assets/images/icon_upload.png";
import upload_focused from "../assets/images/icon_upload_focused.png";

const leftMargin = {
  marginLeft: 12,
};

function Header(props) {
  const [isLoggedIn, setLoggedIn] = useState(false);

  useEffect(() => {
    if (
      props.match.path === "/" ||
      props.match.path === "/login" ||
      props.match.path === "/register"
    ) {
      setLoggedIn(false);
    } else {
      setLoggedIn(true);
    }
    return () => {};
  }, [props.match.path]);

  function navigate(where) {
    if (props.match.path !== where) props.history.push(where);
  }

  return (
    <div className="header row-fixed" style={{ display: "flex" }}>
      <img
        src={logo}
        alt="logo"
        style={{
          padding: 12,
          cursor: "pointer",
          width: "64px",
        }}
        onClick={() => {
          if (isLoggedIn) {
            window.location.href = "/home";
          } else {
            window.location.href = "/";
          }
        }}
      />
      {isLoggedIn && (
        <>
          <div className="header-title">{props.title}</div>
          <div className="header-navbuttons">
            <img
              className="clickable"
              src={props.match.path === "/home" ? home_focused : home}
              alt=""
              onClick={() => {
                navigate("/home");
              }}
            />
            <img
              className="clickable"
              src={props.match.path === "/likes" ? likes_focused : likes}
              style={leftMargin}
              alt=""
              onClick={() => {
                navigate("/likes");
              }}
            />
            <img
              className="clickable"
              src={props.match.path === "/upload" ? upload_focused : upload}
              style={leftMargin}
              alt=""
              onClick={() => {
                navigate("/upload");
              }}
            />
            <img
              className="clickable"
              src={props.match.path === "/profile" ? profile_focused : profile}
              style={{ ...leftMargin, marginRight: 12 }}
              alt=""
              onClick={() => {
                navigate("/profile");
              }}
            />
          </div>
        </>
      )}
    </div>
  );
}

export default withRouter(Header);
