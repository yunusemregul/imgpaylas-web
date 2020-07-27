import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";

export default function Register() {
  return (
    <div className="box">
      <Header title="Kayıt Ol" />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center">
            <input className="input" type="text" placeholder="Ad" />
            <br />
            <input
              className="input"
              type="text"
              placeholder="E-posta"
              style={{ marginTop: "10px" }}
            />
            <br />
            <input
              className="input"
              type="text"
              placeholder="Şifre"
              style={{ marginTop: "10px" }}
            />
            <br />
            <input
              className="input"
              type="text"
              placeholder="Şifre Tekrarı"
              style={{ marginTop: "10px" }}
            />
            <br />
            <button className="button" style={{ marginTop: "10px" }}>
              Kayıt Ol
            </button>
          </form>
        </div>
      </DivBackground>
    </div>
  );
}
