import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";
import { withRouter } from "react-router";

const marginTop = { marginTop: "20px" };

function Login(props) {
  return (
    <div className="box">
      <Header />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center" method="post" action="/perform_login">
            <label className="form-label">Giriş Yap</label>
            <br />
            <input
              className="input"
              type="text"
              placeholder="E-posta"
              required={true}
              id="username"
              name="username"
              autoFocus={true}
              style={marginTop}
            />
            <br />
            <input
              className="input"
              type="password"
              placeholder="Şifre"
              style={marginTop}
              required={true}
              id="password"
              name="password"
            />
            <br />
            <button className="button" style={marginTop}>
              Giriş
            </button>
          </form>
        </div>
        <div className="absolute-centerx">
          Hesabın yok mu? <a href="/register">Kayıt Ol</a>
        </div>
      </DivBackground>
    </div>
  );
}

export default withRouter(Login);
