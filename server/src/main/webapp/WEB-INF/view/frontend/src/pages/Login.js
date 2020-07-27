import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";

export default function Login(props) {
  return (
    <div className="box">
      <Header title="Giriş Yap" />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center" method="post" action="/perform_login">
            <input
              className="input"
              type="text"
              placeholder="E-posta"
              required={true}
              id="username"
              name="username"
              autoFocus={true}
            />
            <br />
            <input
              className="input"
              type="password"
              placeholder="Şifre"
              style={{ marginTop: "10px" }}
              required={true}
              id="password"
              name="password"
            />
            <br />
            <button className="button" style={{ marginTop: "10px" }}>
              Giriş
            </button>
          </form>
        </div>
      </DivBackground>
    </div>
  );
}
