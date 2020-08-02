import React, { useState } from "react";
import icon_profile from "../assets/images/icon_profile.png";
import icon_likes from "../assets/images/icon_likes.png";
import axios from "axios";

export default function ImageBox({ data }) {
  const [imageLoaded, setImageLoaded] = useState(false);

  return (
    <div className="imagebox">
      <div
        className="imagebox-imgbox"
        style={{ backgroundColor: "rgba(" + data.col + ", 1)" }} // fotoğraf yüklenene kadar temsilen fotoğrafın ortalama rengini gösteriyoruz
      >
        <img
          className="imagebox-img"
          src={data.url}
          loading="lazy"
          alt={data.desc}
          height={
            // fotoğraf daha yüklenmediğinde fotoğrafın yüksekliğini temsilen gösteriyoruz
            // fotoğraf yüklendiğinde layoutta hareketlilik olmasın diye
            !imageLoaded && data.h / (data.w / (window.innerWidth / 3.333))
          }
          style={{ width: "100%" }}
          onLoad={() => {
            setImageLoaded(true);
          }}
        />
      </div>
      <div className="imagebox-desc">
        <div style={{ flex: "1 1 auto" }}>
          {data.desc}
          <br />
          <img
            src={icon_profile}
            width="20px"
            style={{ transform: "translateY(5px)", marginRight: "5px" }}
            alt=""
          />
          {data.uname}
        </div>
        <div
          onClick={() => {
            axios.put("/api/v1/like/image/" + data.id);
          }}
        >
          {data.likes}{" "}
          <img
            style={{ width: "20px", transform: "translateY(5px)" }}
            src={icon_likes}
          />
        </div>
      </div>
    </div>
  );
}
