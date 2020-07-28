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
              required={true}
              name="name"
              id="name"
            />
            <br />
            <input
              className="input"
              type="email"
              placeholder="E-posta"
              style={marginTop}
              required={true}
              name="email"
              id="email"
            />
            <br />
            <input
              className="input"
              type="password"
              placeholder="Şifre"
              style={marginTop}
              required={true}
              name="password"
              id="password"
            />
            <br />
            <input
              className="input"
              type="password"
              placeholder="Şifre Tekrarı"
              style={marginTop}
              required={true}
              name="password_again"
              id="password_again"
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
