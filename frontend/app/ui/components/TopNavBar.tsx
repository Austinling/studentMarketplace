"use client";

import {
  Dialog,
  DialogTrigger,
  DialogContent,
  DialogPortal,
} from "@/components/ui/dialog";
import Image from "next/image";
import Link from "next/link";
import { AuthForm } from "./AuthForm";
import { useState } from "react";
import { VerificationCodeInput } from "./VerificationCodeInput";
import { VerificationSuccess } from "./VerificationSuccess";

export interface FormDetails {
  username: string;
  email: string;
  password: string;
  confirmPassword: string;
}

export function TopNavBar() {
  const [registerOpen, setRegisterOpen] = useState<boolean>(false);
  const [loginOpen, setLoginOpen] = useState<boolean>(false);
  const [verificationOpen, setVerificationOpen] = useState<boolean>(false);
  const [verificationSuccessOpen, setVerificationSuccessOpen] =
    useState<boolean>(false);

  const [formDetails, setFormDetails] = useState<FormDetails>({
    username: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  const handleOpen = (type: string) => {
    if (type === "Register") {
      setFormDetails({
        username: "",
        email: "",
        password: "",
        confirmPassword: "",
      });
      setLoginOpen(true);
      setRegisterOpen(false);
    } else {
      setFormDetails({
        username: "",
        email: "",
        password: "",
        confirmPassword: "",
      });
      setLoginOpen(false);
      setRegisterOpen(true);
    }
  };

  const handleVerification = () => {
    setVerificationOpen(true);
    setRegisterOpen(false);
  };

  const handleVerificationSuccess = () => {
    setVerificationOpen(false);
    setVerificationSuccessOpen(true);
  };

  return (
    <header className="sticky top-0 h-20 bg-green-200">
      <nav
        aria-label={"Top NavBar"}
        className="flex items-center justify-between h-full px-4"
      >
        <div className="flex items-center gap-3">
          <Image
            className="object-contain"
            src="/alien.svg"
            alt="Alien Logo"
            width={48}
            height={48}
            priority
          />
          <Link href="/homepage" className="font-roboto font-bold text-2xl">
            Supaplace
          </Link>
        </div>

        <div>
          <ul></ul>
        </div>

        <div className="flex gap-6">
          <Dialog open={loginOpen} onOpenChange={setLoginOpen}>
            <DialogTrigger
              render={
                <button
                  onClick={() => handleOpen("Register")}
                  className="p-3 px-8 rounded-4xl w-auto bg-black text-white"
                >
                  Login
                </button>
              }
            ></DialogTrigger>
            <DialogPortal>
              <DialogContent>
                <AuthForm
                  formDetails={formDetails}
                  setFormDetails={setFormDetails}
                  setOpen={handleOpen}
                  type="Login"
                />
              </DialogContent>
            </DialogPortal>
          </Dialog>

          <Dialog open={registerOpen} onOpenChange={setRegisterOpen}>
            <DialogTrigger
              render={
                <button
                  onClick={() => handleOpen("Login")}
                  className="p-3 px-8 rounded-4xl w-auto bg-white text-black"
                >
                  Register
                </button>
              }
            ></DialogTrigger>
            <DialogContent>
              <AuthForm
                formDetails={formDetails}
                setFormDetails={setFormDetails}
                openVerification={handleVerification}
                setOpen={handleOpen}
                type="Register"
              />
            </DialogContent>
          </Dialog>

          <Dialog open={verificationOpen} onOpenChange={setVerificationOpen}>
            <DialogContent>
              <VerificationCodeInput
                handleSuccess={handleVerificationSuccess}
                email={formDetails.email}
              />
            </DialogContent>
          </Dialog>

          <Dialog
            open={verificationSuccessOpen}
            onOpenChange={setVerificationSuccessOpen}
          >
            <DialogContent>
              <VerificationSuccess />
            </DialogContent>
          </Dialog>
        </div>
      </nav>
    </header>
  );
}
