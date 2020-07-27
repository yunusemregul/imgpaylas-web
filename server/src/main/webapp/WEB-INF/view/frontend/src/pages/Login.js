import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";

export default function Login(props) {
  return (
    <div className="box">
      <Header title="Giriş Yap" />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center">
            <input className="input" type="text" placeholder="E-posta" />
            <br />
            <input
              className="input"
              type="text"
              placeholder="Şifre"
              style={{ marginTop: "10px" }}
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