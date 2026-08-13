"use client";
import Image from "next/image";
import Link from "next/link";
import { redirect } from "next/navigation";
import { FormEvent, useState } from "react";
import styles from "../modules/home.module.css";
import {
  confirmPasswordValidation,
  validateEmail,
  validatePassword,
  validateUsername,
} from "@/app/lib/validators";
import clsx from "clsx";

interface AuthProps {
  setOpen: (type: string) => void;
  type: "Login" | "Register";
  openVerification?: () => void;
}

interface FormDetails {
  username: string;
  email: string;
  password: string;
  confirmPassword: string;
}

interface FormClicked {
  username: boolean;
  email: boolean;
  password: boolean;
  confirmPassword: boolean;
}

export function AuthForm({ setOpen, type, openVerification }: AuthProps) {
  const [formDetails, setFormDetails] = useState<FormDetails>({
    username: "",
    email: "",
    password: "",
    confirmPassword: "",
  });
  const [hasClicked, setClicked] = useState<FormClicked>({
    username: false,
    email: false,
    password: false,
    confirmPassword: false,
  });
  const [isLoading, setLoading] = useState<boolean>(false);

  const emailError = hasClicked.email && !validateEmail(formDetails.email);
  const usernameError =
    hasClicked.username && !validateUsername(formDetails.username);
  const passwordError =
    hasClicked.password && !validatePassword(formDetails.password);
  const differentPasswordError =
    hasClicked.confirmPassword &&
    !confirmPasswordValidation(
      formDetails.password,
      formDetails.confirmPassword,
    );

  const handleFormValue = (e: React.ChangeEvent<HTMLInputElement>): void => {
    setFormDetails((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleClicked = (e: React.ChangeEvent<HTMLInputElement>): void => {
    setClicked((prev) => ({ ...prev, [e.target.name]: true }));
  };

  const handleRedOutline = (hasError: boolean) => {
    return clsx(
      "p-3 border-2 w-80 outline-none transition-colors text-sm rounded",
      {
        "border-red-600 focus:border-red-600": hasError,
        "border-gray-200 focus:border-gray-200": !hasError,
      },
    );
  };

  const handleAuth = async (e: FormEvent, authType: string) => {
    const authVariable = authType.toLowerCase();
    const body =
      authVariable === "register"
        ? {
            username: formDetails.username,
            email: formDetails.email,
            password: formDetails.password,
          }
        : {
            email: formDetails.email,
            password: formDetails.password,
          };

    let success = false;
    setLoading(true);
    try {
      const response = await fetch(
        `http://localhost:8082/api/auth/${authVariable}`,
        {
          method: "POST",
          body: JSON.stringify(body),
          headers: {
            "Content-Type": "application/json",
          },
        },
      );

      if (response.ok) {
        const data = await response.json();

        success = true;
      } else {
        console.log("Failure to log in");
      }
    } catch (error) {
      console.error("Error is ", error);
    }

    if (success && authVariable === "register" && openVerification) {
      console.log("This works.");
      openVerification();
    }
  };

  return (
    <form onSubmit={(e) => handleAuth(e, type)}>
      <div className="flex flex-col items-center justify-center py-10 gap-10 transition-all duration-500 ease-in-out">
        <div>
          <h3 className="text-4xl font-roboto">
            Welcome{type == "Register" ? "" : " Back"}!
          </h3>
        </div>
        <div className="flex flex-col gap-6">
          {type == "Register" && (
            <div className="flex flex-col items-center gap-1">
              <input
                className={handleRedOutline(usernameError)}
                type="text"
                placeholder="Enter Your Username"
                name="username"
                value={formDetails.username}
                onChange={(e) => handleFormValue(e)}
                onBlur={(e) => handleClicked(e)}
                required
              ></input>
              {usernameError && (
                <span className="text-sm text-red-700">
                  Username must contain at least 5 characters
                </span>
              )}
            </div>
          )}
          <div className="flex flex-col text-center items-center gap-1">
            <input
              className={handleRedOutline(emailError)}
              type="text"
              placeholder="Email Address"
              name="email"
              value={formDetails.email}
              required
              onChange={(e) => handleFormValue(e)}
              onBlur={(e) => handleClicked(e)}
            ></input>
            {emailError && (
              <span className="text-sm text-red-700">
                You must enter a valid .ac.uk email
              </span>
            )}
          </div>

          <div className="flex flex-col text-center items-center gap-1">
            <input
              className={handleRedOutline(passwordError)}
              type="password"
              placeholder="Password"
              name="password"
              value={formDetails.password}
              onChange={(e) => handleFormValue(e)}
              onBlur={(e) => handleClicked(e)}
              required
            ></input>
            {passwordError && (
              <span className="text-sm text-red-700">
                Passwords must contain at least one uppercase letter, one
                number, one symbol, and at least 8 characters.
              </span>
            )}
          </div>

          {type == "Login" && (
            <div className="flex items-center justify-between">
              <div className="flex gap-2">
                <input type="checkbox" />
                <p>Remember for 30 days</p>
              </div>

              <p className="text-blue-400 underline text-right">
                <Link href="/login">Forgot password?</Link>
              </p>
            </div>
          )}

          {type === "Register" && (
            <div className="flex flex-col text-center items-center gap-1">
              <input
                className={handleRedOutline(differentPasswordError)}
                type="password"
                placeholder="Confirm Password"
                name="confirmPassword"
                value={formDetails.confirmPassword}
                required
                onChange={(e) => handleFormValue(e)}
                onBlur={(e) => handleClicked(e)}
              ></input>
              {differentPasswordError && (
                <span className="text-sm text-red-700">
                  {"Passwords don't match"}
                </span>
              )}
            </div>
          )}
        </div>
        <div className="flex flex-col gap-2">
          <button className="p-3 h-14 w-80 flex items-center justify-center border bg-black text-white">
            {isLoading ? (
              <div className={styles.loader}></div>
            ) : type === "Register" ? (
              "Register"
            ) : (
              "Sign In"
            )}
          </button>
          <button className="p-1 w-80 flex items-center justify-center gap-2 border-gray-200 border-2">
            <Image
              className=""
              src="/google.svg"
              alt="Google Logo"
              width={40}
              height={40}
              priority
            />
            Sign In With Google
          </button>

          <p className="text-blue-400 underline text-center">
            {type == "Register" ? (
              <button onClick={() => setOpen("Register")}>
                {"Already have an account? Sign In Now"}
              </button>
            ) : (
              <button onClick={() => setOpen("Login")}>
                {"Don't have an account? Sign Up Now"}
              </button>
            )}
          </p>
        </div>
      </div>
    </form>
  );
}
