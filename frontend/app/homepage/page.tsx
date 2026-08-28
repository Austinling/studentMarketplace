import { MainSection } from "../features/auth/components/MainSection";
import { TopNavBar } from "../features/auth/components/TopNavBar";
import { InstructionsContainer } from "../features/homePage/components/InstructionsContainer";
import { MainPageCatalog } from "../features/homePage/components/MainPageCatalog";

export default function HomePage() {
  return (
    <main className="flex flex-col h-full">
      <TopNavBar />
      <MainSection />
      <MainPageCatalog />
      <InstructionsContainer />
    </main>
  );
}
