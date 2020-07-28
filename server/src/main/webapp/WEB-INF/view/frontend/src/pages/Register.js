import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";

const marginTop = { marginTop: "20px" };

export default function Register() {
  return (
    <div className="box">
      <Header />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center">
            <label className="form-label">Kayıt Ol</label>
            <br />
            <input
              className="input"
              type="text"
              placeholder="Ad"
              style={marginTop}
            />
            <br />
            <input
              className="input"
              type="text"
              placeholder="E-posta"
              style={marginTop}
            />
            <br />
            <input
              className="input"
              type="text"
              placeholder="Şifre"
              style={marginTop}
            />
            <br />
            <input
              className="input"
              type="text"
              placeholder="Şifre Tekrarı"
              style={marginTop}
            />
            <br />
            <button className="button" style={marginTop}>
              Kayıt Ol
            </button>
          </form>
        </div>
      </DivBackground>
    </div>
  );
}
